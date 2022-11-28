package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentSoliicitudOfertasClienteBinding

class SolicitudesDeCliente : Fragment(){
    private lateinit var binding: FragmentSoliicitudOfertasClienteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSoliicitudOfertasClienteBinding.inflate(layoutInflater)
        iniciar()
        Acciones()
        return binding.root
    }

    private fun iniciar() {
        with(binding) {
            var NombreEmp = ShareObjectAdp.preferShared.getNombre()
            tvNombreEmpresa.text ="Nombre Empresa: "+ NombreEmp

            var DireccionEmp = ShareObjectAdp.preferShared.getDireccion()
            tvDirecEmpresa.text = "Direccion: "+DireccionEmp

            var Repre = ShareObjectAdp.preferShared.getRepresentante()
            tvJefeEmpresa.text ="Representante: "+ Repre

 /*         var Contacto = ShareObjectAdp.preferShared.getContacto()
           tvContacto.text = Contacto
*/
            var CorreoEmp = ShareObjectAdp.preferShared.getCorreoEmp()
            tvCorreoEmpresa.text ="Correo Empresa: "+ CorreoEmp

  /*          var DescripcionEmp = ShareObjectAdp.preferShared.getDescripcionEmp()
            tvDescripEmpresa.text = DescripcionEmp
            */

            var oferta = ShareObjectAdp.preferShared.GetOferta()
            tvNombreOferta.text = "Oferta: "+ oferta

            var refer = ShareObjectAdp.preferShared.GetTexto()
            tvReferencia.text ="Referencia: " +  refer

            var respuesta = ShareObjectAdp.preferShared.GetRespuesta()
            tvRespuesta.text = "Respuesta: " + respuesta


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
            Navigation.findNavController(binding.root).navigate(R.id.PantallaSolicitudesCliente)
        }
    }
}