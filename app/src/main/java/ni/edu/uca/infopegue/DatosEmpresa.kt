package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.databinding.FragmentDatosEmpresaBinding


class DatosEmpresa : Fragment() {
    private lateinit var binding: FragmentDatosEmpresaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDatosEmpresaBinding.inflate(layoutInflater)
        iniciar()
        Atras()
        return binding.root
    }

    private fun iniciar() {


    }

    private fun Atras() {
        binding.IvAtras.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasEmpresa)
        }
    }
}