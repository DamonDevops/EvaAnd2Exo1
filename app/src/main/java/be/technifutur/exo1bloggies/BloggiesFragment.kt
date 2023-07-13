package be.technifutur.exo1bloggies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import be.technifutur.exo1bloggies.databinding.FragmentBloggiesBinding


class BloggiesFragment : Fragment() {
    private lateinit var binding :FragmentBloggiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBloggiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.title = getString(R.string.bloggies)

        binding.twitterConnect.setOnClickListener {
            toSocialConnect("twitter")
        }
        binding.facebookConnect.setOnClickListener {
            toSocialConnect("facebook")
        }
        binding.bloggiesSignUp.setOnClickListener {
            toSignUp()
        }
    }

    private fun toSocialConnect(social :String){
        val destination = BloggiesFragmentDirections.actionBloggiesFragmentToConnexionFragment(social)
        findNavController().navigate(destination)
    }

    private fun toSignUp() {
        val destination = BloggiesFragmentDirections.actionBloggiesFragmentToSignUpFragment()
        findNavController().navigate(destination)
    }
}