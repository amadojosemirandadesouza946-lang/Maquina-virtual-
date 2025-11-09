package com.aurora.launcher

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val SAMP_URI = "samp://188.165.192.24:5644"
    private val FALLBACK_URL = "https://aurora-stream.example/placeholder" // change if needed
    private val DISCORD_INVITE = "https://discord.gg/xjsUqwvkVB"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnDiscord = findViewById<Button>(R.id.btnDiscord)

        btnPlay.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(SAMP_URI))
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                // no app handles samp://, show fallback
                AlertDialog.Builder(this)
                    .setTitle("Abrir servidor")
                    .setMessage("Nenhum aplicativo de SAMP detectado. Deseja abrir uma sessão web de fallback?")
                    .setPositiveButton("Abrir web") { _, _ ->
                        val i = Intent(Intent.ACTION_VIEW, Uri.parse(FALLBACK_URL))
                        startActivity(i)
                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao tentar conectar: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        btnDiscord.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(DISCORD_INVITE))
            startActivity(i)
        }
    }
}