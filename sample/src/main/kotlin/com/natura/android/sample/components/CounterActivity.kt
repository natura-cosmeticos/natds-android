package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.counter.Counter
import com.natura.android.sample.databinding.ActivityCounterBinding
import com.natura.android.sample.setChosenDefaultTheme

class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.counterAddDisable.addDescription = "Adicionar quantidade"
        binding.counterAddDisable.subtractDescription = "Remover quantidade"
        binding.counterAddDisable.inputValue = 1

        binding.counterSubtractDisable.inputValue = 5

        binding.counterSemix.size = Counter.SEMIX_SIZE
        binding.counterSemix.label = "Dynamic Label"

        supportActionBar?.title = "Counter"
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
