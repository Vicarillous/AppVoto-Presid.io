package com.example.appvoto

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class VideoPlayer : AppCompatActivity() {
    private var videoCurrentPositon: Long = 0
    private lateinit var playerView: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        createVideoPlayer() // Cria o player de vídeo

        val goBackButton = findViewById<ImageButton>(R.id.go_back_button)

        goBackButton.setOnClickListener {
            returnCurrentPosition() // Retorna a posição atual do vídeo
        }
    }

    private fun createVideoPlayer() {
        videoCurrentPositon = intent.getLongExtra("video_current_position", 0) // Pega a posição atual do vídeo

        var videoView = findViewById<StyledPlayerView>(R.id.videoView)
        var videoPath = "android.resource://" + packageName + "/" + R.raw.a_importancia_do_voto // Caminho do vídeo
        var videoUri = Uri.parse(videoPath) // Cria a Uri do vídeo

        val mediaItem: MediaItem = MediaItem.fromUri(videoUri) // Cria o item do vídeo

        playerView = ExoPlayer.Builder(this).build() // Cria o player

        videoView.player = playerView // seta o player no videoView
        playerView.setMediaItem(mediaItem) // seta o item do vídeo
        playerView.prepare() // Prepara o player
        playerView.seekTo(videoCurrentPositon) // Seleciona o vídeo na posição atual
        playerView.playWhenReady = true
        playerView.play()
    }

    override fun onPause() {
        super.onPause()
        playerView.playWhenReady = false
    }

    override fun onDestroy() {
        super.onDestroy()

        playerView.release() // Libera o player
    }

    override fun onBackPressed() {
        returnCurrentPosition()
    }

    private fun returnCurrentPosition() {
        val returnIntent = Intent()
        returnIntent.putExtra("video_current_position", playerView.currentPosition) // Retorna a posição atual do vídeo
        setResult(RESULT_OK, returnIntent)
        finish() // Fecha a activity
    }
}