package com.rzs.jokes.presentation.joke

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.rzs.jokes.R
import com.rzs.jokes.databinding.FragmentJokeBinding
import com.rzs.jokes.di.PresentationModule.provideViewModelFactory
import com.rzs.jokes.presentation.core.UiPresentation
import com.rzs.jokes.presentation.joke.model.JokeAttrs
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class JokeFragment : Fragment(), UiPresentation<JokeUiState> {
    private var binding: FragmentJokeBinding? = null
    private val viewModel: JokesViewModel by viewModels { provideViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUiStatesObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = FragmentJokeBinding.inflate(inflater, container, false)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emitUiEvent(JokeUiEvent.InitialUiEvent(lang = "es"))
        getNewJoke()
    }

    private fun getNewJoke() {
        binding?.newJoke?.setOnClickListener {
            emitUiEvent(JokeUiEvent.GetAnotherJokeUiEvent(lang = "es"))
          //  val mediaPlayer: MediaPlayer? = MediaPlayer.create(context, R.raw.dead8bits)
           // mediaPlayer?.start()
        }
    }

    private fun emitUiEvent(uiEvent: JokeUiEvent) {
        lifecycleScope.launch {
            viewModel.processUiEvent(uiEvent)
        }
    }

    override fun renderUiStates(uiState: JokeUiState) {
        when (uiState) {
            JokeUiState.LoadingUiState -> {
                binding?.progressCircular?.isVisible = true
            }

            is JokeUiState.ShowJokeUiState -> {
                drawJoke(jokeAttrs = uiState.jokeAttrs)
            }

            JokeUiState.ErrorUiState -> {
                binding?.progressCircular?.isInvisible = true
            }
        }
    }

    private fun drawJoke(jokeAttrs: JokeAttrs) {
        binding?.progressCircular?.isInvisible = true

        binding?.tvCategory?.text = jokeAttrs.category
        if (jokeAttrs.question.isNotEmpty()) {
            binding?.firstPartJoke?.visibility = View.VISIBLE
            binding?.firstPartJoke?.text = jokeAttrs.question
            binding?.jokeAnswer?.text = jokeAttrs.response
            binding?.cat11?.visibility=View.VISIBLE
            binding?.cat22?.visibility=View.GONE
           // val mediaPlayer: MediaPlayer? = MediaPlayer.create(context, R.raw.miau1)
            //mediaPlayer?.start()
        } else {
            binding?.firstPartJoke?.visibility = View.GONE
            binding?.jokeAnswer?.text = jokeAttrs.joke
            binding?.cat11?.visibility=View.GONE
            binding?.cat22?.visibility=View.VISIBLE
            //val mediaPlayer: MediaPlayer? = MediaPlayer.create(context, R.raw.miau2)
            //mediaPlayer?.start()
        }
    }

    private fun setupUiStatesObserver() {
        with(viewModel) {
            uiState().onEach { renderUiStates(it) }.launchIn(lifecycleScope)
        }
    }
}