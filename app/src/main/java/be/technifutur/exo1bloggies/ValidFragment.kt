package be.technifutur.exo1bloggies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import be.technifutur.exo1bloggies.databinding.FragmentValidBinding

class ValidFragment : Fragment() {
    private lateinit var binding :FragmentValidBinding
    private val args :ValidFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentValidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(args.social) {
            "twitter" -> binding.socialBanner.setImageResource(R.drawable.twitter)
            "facebook" -> binding.socialBanner.setImageResource(R.drawable.facebook)
        }

        binding.textView.text = getString(R.string.valid_connexion)
    }
}