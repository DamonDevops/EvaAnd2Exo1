package be.technifutur.exo1bloggies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import be.technifutur.exo1bloggies.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding :FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupButton.setOnClickListener {
            when(validator()){
                "loginEmpty" -> { AlertDialog.Builder(requireContext()).setTitle("Erreur").setMessage("Le login n'a pas été rempli").setPositiveButton("OK", null).show()}
                "emailEmpty" -> { AlertDialog.Builder(requireContext()).setTitle("Erreur").setMessage("L'email n'a pas été rempli").setPositiveButton("OK", null).show()}
                "emailInvalid" -> { AlertDialog.Builder(requireContext()).setTitle("Erreur").setMessage("L'email est invalide").setPositiveButton("OK", null).show()}
                "passwordInvalid" -> { AlertDialog.Builder(requireContext()).setTitle("Erreur").setMessage("Les mots de passe ne correspondent pas").setPositiveButton("OK", null).show()}
                "passwordEmpty" -> { AlertDialog.Builder(requireContext()).setTitle("Erreur").setMessage("Un champ mot de passe n'a pas été rempli").setPositiveButton("OK", null).show()}
                else -> {
                    val destination = SignUpFragmentDirections.actionSignUpFragmentToInscriptionValidFragment(binding.signLoginField.text.toString())
                    findNavController().navigate(destination)
                }
            }
        }
    }

    private fun validator() :String{
        if(binding.signLoginField.text.isNullOrEmpty()){ return "loginEmpty" }
        if(binding.signEmailField.text.isNullOrEmpty()){ return "emailEmpty"}
        if(!binding.signEmailField.text.contains("@")){return "emailInvalid"}
        if(binding.signPasswordField.text.isNullOrEmpty() || binding.confirmSignPasswordField.text.isNullOrEmpty()){return "passwordEmpty"}
        if(binding.signPasswordField.text.toString() != binding.confirmSignPasswordField.text.toString()){return "passwordInvalid"}
        return "valid"
    }


}