package com.dev.tiktok_compose.presentation.component

import android.graphics.Color
import android.view.LayoutInflater
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.LoadControl
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import androidx.media3.exoplayer.trackselection.TrackSelector
import androidx.media3.exoplayer.upstream.DefaultAllocator
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.DefaultTimeBar
import androidx.media3.ui.PlayerView
import androidx.media3.ui.TimeBar
import androidx.media3.ui.TimeBar.OnScrubListener
import com.dev.tiktok_compose.R

@Composable
fun VideoPlayer(
    modifier: Modifier = Modifier,
    url: String,
    play: Boolean
) {
    val exoPlayer = rememberExoPlayerWithLifecycle(url)
    val playerView = rememberPlayerView(exoPlayer)

    playerView.apply {
        useController = false
    }

    playerView.setOnClickListener {
        if (exoPlayer.isPlaying) {
            playerView.useController = true
            exoPlayer.pause()
        } else {
            playerView.useController = false
            exoPlayer.play()
        }
    }

    exoPlayer.playWhenReady = play

    AndroidView(
        factory = { playerView },
        modifier = modifier
    )

    val lifecycleOwner by rememberUpdatedState(LocalLifecycleOwner.current)
    val lifecycle = lifecycleOwner.lifecycle
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> {
                    playerView.onPause()
                    exoPlayer.pause()
                }
                Lifecycle.Event.ON_RESUME -> {
                    playerView.onResume()
                }
                else -> Unit
            }
        }
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
}

@Composable
fun rememberExoPlayerWithLifecycle(
    url: String
): ExoPlayer {
    val context = LocalContext.current
    val loadControl: LoadControl = DefaultLoadControl.Builder()
        .setAllocator(DefaultAllocator(true, 16))
        .setBufferDurationsMs(
            MIN_BUFFER_DURATION,
            MAX_BUFFER_DURATION,
            MIN_PLAYBACK_START_BUFFER,
            MIN_PLAYBACK_RESUME_BUFFER
        )
        .setTargetBufferBytes(-1)
        .setPrioritizeTimeOverSizeThresholds(true)
        .build()
    val trackSelector: TrackSelector = DefaultTrackSelector(context).apply {
        setParameters(buildUponParameters().setMaxVideoSizeSd())
    }
    val exoPlayer = remember(url) {
        ExoPlayer.Builder(context)
            .setLoadControl(loadControl)
            .setTrackSelector(trackSelector)
//            .setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING)
            .build().apply {
                repeatMode = Player.REPEAT_MODE_ONE
                val defaultDataSource = DefaultHttpDataSource.Factory()
                val source = ProgressiveMediaSource.Factory(defaultDataSource)
                    .createMediaSource(MediaItem.fromUri(url))
                setMediaSource(source)
                prepare()
            }
    }

    DisposableEffect(key1 = true) {
        onDispose {
            exoPlayer.release()
        }
    }

    return exoPlayer
}

@Composable
fun rememberPlayerView(exoPlayer: ExoPlayer): PlayerView {
    val context = LocalContext.current
    val playerView = remember {
        val layout = LayoutInflater.from(context).inflate(R.layout.player_view, null, false)
        val playerView = layout.findViewById(R.id.playerView) as PlayerView

        playerView.apply {
            player = exoPlayer
            setShutterBackgroundColor(Color.TRANSPARENT)
            setKeepContentOnPlayerReset(true)
            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
        }
    }

    DisposableEffect(key1 = true) {
        onDispose {
            playerView.player = null
        }
    }

    return playerView
}

private const val MIN_BUFFER_DURATION = 2000
private const val MAX_BUFFER_DURATION = 5000
private const val MIN_PLAYBACK_START_BUFFER = 1500
private const val MIN_PLAYBACK_RESUME_BUFFER = 2000