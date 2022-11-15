package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.R
import ni.edu.uca.infopegue.databinding.FragmentLoginEmpresaBinding


class LoginEmpresa : Fragment(){
    private lateinit var binding: FragmentLoginEmpresaBinding
    val nombreClave:String = "UCA"
    val pwdClave:String = "Damo1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginEmpresaBinding.inflate(layoutInflater)
        iniciar()
        return binding.root
    }

    private fun iniciar() {

        binding.btnIngresar.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasEmpresa)
        }

    }
}