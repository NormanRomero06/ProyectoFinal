package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp.Companion.preferShared
import ni.edu.uca.infopegue.databinding.FragmentNuevaOfertaBinding
import ni.edu.uca.infopegue.entidades.Oferta

class NuevaOferta : Fragment() {
    private lateinit var binding: FragmentNuevaOfertaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNuevaOfertaBinding.inflate(layoutInflater)
        iniciar()
        Acciones()
        return binding.root
    }

    private fun iniciar() {
        with(binding) {
            btnCrear.setOnClickListener {
                var nombreOf = etNombreOferta.text.toString()
                var descripcioOf = etInformacion2.text.toString()
                var contactoOf = etContacto.text.toString()
                var ubicacionOf = etUbicacion.text.toString()
                var requisitosOf = etRequisitos.text.toString()


                var arreglo = HashMap<String, Oferta>()
                arreglo = preferShared.getArray()
                var oferta: Oferta =
                    Oferta(nombreOf, descripcioOf, contactoOf, ubicacionOf, requisitosOf)

                var newKey = preferShared.createKey()
                var oldKey: String = ""
                for (llave in arreglo.keys) {
                    oldKey = llave
                }
                with(preferShared) {
                    saveKey(oldKey, newKey)
                    saveNameOf(newKey, nombreOf)
                    saveDescripcionOf(newKey, descripcioOf)
                    saveContactoOf(newKey, contactoOf)
                    saveUbicacionOf(newKey, ubicacionOf)
                    saveRequisitoOf(newKey, requisitosOf)
                }
              limpiar()
            }
        }
    }

    fun limpiar() {
        with(binding) {
            etNombreOferta.setText("")
            etUbicacion.setText("")
            etInformacion2.setText("")
            etContacto.setText("")
            etRequisitos.setText("")
            Toast.makeText(context, "Campos Limpios", Toast.LENGTH_SHORT).show()
        }
    }

    private fun Acciones() {

        binding.IvPersona.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaDatosEmpresa)
        }
        binding.IvInicio.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasEmpresa)
        }
        binding.IvMail.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaRespuestasDeOfertas)
        }
    }
}