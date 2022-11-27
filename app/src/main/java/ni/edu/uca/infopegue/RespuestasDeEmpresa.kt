package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
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
        cargar()
        respuesta()


        return binding.root

    }

    private fun cargar(){
        with(binding) {
            var Pnombre = ShareObjectAdp.preferShared.getFnombre()
            tvPrimerNombre.text = Pnombre

            var Snombre = ShareObjectAdp.preferShared.getSnombre()
            tvSegundoNombre.text = Snombre

            var Papellido = ShareObjectAdp.preferShared.getFapellido()
            tvPrimerApellido.text = Papellido

            var Sapellido = ShareObjectAdp.preferShared.getSapellido()
            tvSegundoApellido.text = Sapellido

            var Edad = ShareObjectAdp.preferShared.getEdad()
            tvEdad.text = Edad.toString()

            var Profesion = ShareObjectAdp.preferShared.getProfesion()
            tvProfesion.text = Profesion

            var Gmail = ShareObjectAdp.preferShared.getCorreo()
            tvCorreoPersonal.text = Gmail

            var oferta = ShareObjectAdp.preferShared.GetOferta()
            tvOferta.text = oferta

            var mostrar = ShareObjectAdp.preferShared.GetTexto()
            tvReferencia.text = mostrar
        }
    }

    private fun respuesta(){
        binding.btnEnviar.setOnClickListener {
            val opcion = binding.autoCompleteTextView
            ShareObjectAdp.preferShared.SaveTexto(binding.tvReferencia.text.toString())
            ShareObjectAdp.preferShared.SaveRespuesta(opcion.text.toString())
        }
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