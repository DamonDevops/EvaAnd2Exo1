package be.technifutur.exo1bloggies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import be.technifutur.exo1bloggies.databinding.FragmentInscriptionValidBinding

class InscriptionValidFragment : Fragment() {
    private lateinit var binding :FragmentInscriptionValidBinding
    private val args :InscriptionValidFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInscriptionValidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        "Bienvenue ${args.login}".also { binding.textView2.text = it }
    }
}