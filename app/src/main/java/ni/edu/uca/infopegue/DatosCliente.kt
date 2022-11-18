package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp.Companion.preferShared
import ni.edu.uca.infopegue.databinding.FragmentDatosClienteBinding


class DatosCliente : Fragment() {
    private lateinit var binding: FragmentDatosClienteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDatosClienteBinding.inflate(layoutInflater)
        iniciar()
        Botones()
        return binding.root
    }

    private fun iniciar() {
        with(binding) {
            var Pnombre = preferShared.getFnombre()
            tvPrimerNombre.text = Pnombre

            var Snombre = preferShared.getSnombre()
            tvSegundoNombre.text = Snombre

            var Papellido = preferShared.getFapellido()
            tvPrimerApellido.text = Papellido

            var Sapellido = preferShared.getSapellido()
            tvSegundoApellido.text = Sapellido

            var Edad = preferShared.getEdad()
            tvEdad.text = Edad.toString()

            var Profesion = preferShared.getProfesion()
            tvProfesion.text = Profesion

            var Gmail = preferShared.getCorreo()
            tvCorreoPersonal.text = Gmail

            var Descripcion = preferShared.getDescripcion()
            tvDescripPersonal.text = Descripcion
        }
    }

    private fun Botones() {
        binding.IvAtras.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasCliente)
        }
        binding.ivEditar.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaCrudCliente)
        }
    }
}