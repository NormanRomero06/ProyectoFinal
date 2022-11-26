package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.databinding.FragmentRespuestasOfertasEmpresaBinding

class RespuestasDeEmpresa : Fragment(){
    private lateinit var binding: FragmentRespuestasOfertasEmpresaBinding

    override fun onResume() {
        super.onResume()
        val opciones = resources.getStringArray(R.array.Opciones)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item, opciones)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRespuestasOfertasEmpresaBinding.inflate(inflater, container, false)
        Acciones()

        return binding.root

    }

    private fun Acciones() {

        binding.IvPersona.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaDatosCliente)
        }
        binding.IvInicio.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasCliente)
        }
        binding.IvMail.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaRespuestasDeOfertas)
        }
    }
}