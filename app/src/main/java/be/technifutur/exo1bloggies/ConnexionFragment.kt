package be.technifutur.exo1bloggies

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import be.technifutur.exo1bloggies.databinding.FragmentConnexionBinding

class ConnexionFragment : Fragment() {
    private lateinit var binding :FragmentConnexionBinding
    private val args :ConnexionFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConnexionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.title = "${args.social} Login"

        when(args.social){
            "twitter" -> binding.socialBanner.setImageResource(R.drawable.twitter)
            "facebook" -> binding.socialBanner.setImageResource(R.drawable.facebook)
        }

        binding.connexionButton.setOnClickListener {
            if(!connectValidation()){
                callAlert()
            }else{
                showValidationScreen()
            }
        }
    }

    private fun connectValidation() :Boolean{
        return (binding.emailField.text.isNotEmpty() && binding.passwordField.text.isNotEmpty())
    }
    private fun callAlert(){
        AlertDialog.Builder(requireContext()).setTitle("Erreur").setMessage("Login Incomplet").setPositiveButton("OK", null).show()
    }
    private fun showValidationScreen(){
        val destination = ConnexionFragmentDirections.actionConnexionFragmentToValidFragment(args.social)
        findNavController().navigate(destination)
    }
}