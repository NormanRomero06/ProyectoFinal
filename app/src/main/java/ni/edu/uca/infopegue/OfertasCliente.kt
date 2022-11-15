package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.databinding.FragmentOfertasClienteBinding

class OfertasCliente : Fragment(){
    private lateinit var binding: FragmentOfertasClienteBinding
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

        binding = FragmentOfertasClienteBinding.inflate(layoutInflater)
        iniciar()
        return binding.root
    }

    private fun iniciar() {
    }
}