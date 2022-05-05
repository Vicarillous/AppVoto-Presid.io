package com.example.appvoto

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView


class DeveVotar : AppCompatActivity() {
    private lateinit var playerView: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deve_votar)

        createVideoPlayer()

        onClick()
    }

    private fun onClick() {
        val fullScreenButton = findViewById<Button>(R.id.button2)

        fullScreenButton.setOnClickListener {
            playerView.pause()

            val i = Intent(this, VideoPlayer::class.java)
            i.putExtra("video_current_position", playerView.currentPosition) // passando a posição do video
            startActivityForResult(i, 1)
        }
    }

    private fun createVideoPlayer() {
        var videoView = findViewById<StyledPlayerView>(R.id.videoView)
        var videoPath = "android.resource://" + packageName + "/" + R.raw.a_importancia_do_voto // caminho do video
        var videoUri = Uri.parse(videoPath) // criando a Uri

        val mediaItem: MediaItem = MediaItem.fromUri(videoUri) // criando o item do video

        playerView = ExoPlayer.Builder(this).build() // criando o player

        videoView.player = playerView // setando o player no videoView
        playerView.setMediaItem(mediaItem) // setando o item do video
        playerView.prepare() // preparando o player

    }

    override fun onDestroy() {
        super.onDestroy()
        playerView.release() // libera o player
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) { // se o usuario clicou no botao de voltar
                playerView.seekTo(data!!.getLongExtra("video_current_position", 0)) // volta para a posicao do video
                playerView.play() // inicia o video
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}