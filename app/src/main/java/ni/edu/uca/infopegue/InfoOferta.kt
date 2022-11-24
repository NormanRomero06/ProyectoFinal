package ni.edu.uca.infopegue

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentInfoOfertaBinding
import org.w3c.dom.Text

class  InfoOferta : Fragment() {
    private lateinit var binding: FragmentInfoOfertaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInfoOfertaBinding.inflate(layoutInflater)
        iniciar()
        Acciones()
        val email : TextView = binding.tvEmail
        email.movementMethod = LinkMovementMethod.getInstance()
        email.setLinkTextColor(Color.BLUE)

        return binding.root
    }

    private fun iniciar() {
        var tempKey = ShareObjectAdp.preferShared.getTempKey()

        with(binding) {
            etNombreOferta.setText(ShareObjectAdp.preferShared.getNombreOf(tempKey))
            etContacto.setText(ShareObjectAdp.preferShared.getContactoOf(tempKey))
            etRequisitos.setText(ShareObjectAdp.preferShared.getRequisitoOf(tempKey))
            etUbicacion.setText(ShareObjectAdp.preferShared.getUbicacionOf(tempKey))
            etDescripOferta.setText(ShareObjectAdp.preferShared.getDescripcionOf(tempKey))


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