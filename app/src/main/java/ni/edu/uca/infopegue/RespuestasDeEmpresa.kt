package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ni.edu.uca.infopegue.databinding.FragmentRespuestasOfertasEmpresaBinding

class RespuestasDeEmpresa : Fragment(){
    private lateinit var binding: FragmentRespuestasOfertasEmpresaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRespuestasOfertasEmpresaBinding.inflate(layoutInflater)
        iniciar()
        return binding.root
    }

    private fun iniciar() {


    }
}