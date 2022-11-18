package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp.Companion.preferShared
import ni.edu.uca.infopegue.databinding.FragmentCrudClienteBinding

class CrudCliente : Fragment() {
    private lateinit var binding: FragmentCrudClienteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrudClienteBinding.inflate(layoutInflater)
        Guardar()
        Acciones()
        AccionClean()
        BorrarDatos()
        CargarDatos()
        return binding.root
    }

    private fun Guardar() {

        binding.btnGuardar.setOnClickListener {


            if (binding.etPrimerNombre.text.toString().isNotEmpty()) {
                preferShared.saveFnombre(binding.etPrimerNombre.text.toString())
            } else {
                Toast.makeText(this.context, "Inserte Primer Nombre", Toast.LENGTH_SHORT).show()
            }

            if (binding.etSegundoNombre.text.toString().isNotEmpty()) {
                preferShared.saveSnombre(binding.etSegundoNombre.text.toString())
            }

            if (binding.etPrimerApellido.text.toString().isNotEmpty()) {
                preferShared.saveFapellido(binding.etPrimerApellido.text.toString())
            } else {
                Toast.makeText(this.context, "Inserte Primer Apellido", Toast.LENGTH_SHORT).show()
            }
            if (binding.etSegundoApellido.text.toString().isNotEmpty()) {
                preferShared.saveSapellido(binding.etSegundoApellido.text.toString())
            }
            if (binding.etEdad.text.toString().isNotEmpty()) {
                preferShared.saveEdad(binding.etEdad.text.toString().toInt())
            } else {
                Toast.makeText(this.context, "Inserte Edad", Toast.LENGTH_SHORT).show()
            }
            if (binding.etProfesion.text.toString().isNotEmpty()) {
                preferShared.saveProfesion(binding.etProfesion.text.toString())
            } else {
                Toast.makeText(this.context, "Inserte Profesion", Toast.LENGTH_SHORT).show()
            }

            if (binding.etCorreoPersonal.text.toString().isNotEmpty()) {
                preferShared.saveCorreo(binding.etCorreoPersonal.text.toString())
            } else {
                Toast.makeText(this.context, "Digite un correo", Toast.LENGTH_SHORT).show()
            }

            if (binding.etDescripPersonal.text.toString().isNotEmpty()) {
                preferShared.saveDescripcion(binding.etDescripPersonal.text.toString())
            } else {
                Toast.makeText(this.context, "Inserte Una Descripcion", Toast.LENGTH_SHORT).show()
            }

            Toast.makeText(this.context, "Datos Guardados ", Toast.LENGTH_SHORT).show()

        }

    }

    private fun AccionClean() {
        binding.btnLimpiar.setOnClickListener { limpiar() }
    }

    fun limpiar() {
        with(binding) {
            etPrimerNombre.setText("")
            etSegundoNombre.setText("")
            etPrimerApellido.setText("")
            etSegundoApellido.setText("")
            etEdad.setText("")
            etProfesion.setText("")
            etCorreoPersonal.setText("")
            etDescripPersonal.setText("")



        }
        Toast.makeText(this.context, "Campos limpios", Toast.LENGTH_SHORT).show()
    }

    private fun BorrarDatos() {
        binding.btnEliminar.setOnClickListener {
            with(binding) {
                preferShared.RemoveNombre(etPrimerNombre.text.toString())
                preferShared.RemoveNombre2(etSegundoNombre.text.toString())
                preferShared.RemoveApellido(etPrimerApellido.text.toString())
                preferShared.RemoveApellido2(etSegundoApellido.text.toString())
                preferShared.RemoveEdad(etEdad.text.toString().toInt())
                preferShared.RemoveProfesion(etProfesion.text.toString())
                preferShared.RemoveCorreo(etCorreoPersonal.text.toString())
                preferShared.RemoveDescripcion(etDescripPersonal.text.toString())

            }
            Toast.makeText(this.context, "Datos Borrados", Toast.LENGTH_SHORT).show()
            limpiar()

        }
    }

    private fun CargarDatos() {
        with(binding) {
            etPrimerNombre.setText(preferShared.getFnombre())
            etSegundoNombre.setText(preferShared.getSnombre())
            etPrimerApellido.setText(preferShared.getFapellido())
            etSegundoApellido.setText(preferShared.getSapellido())
            etEdad.setText(preferShared.getEdad().toString())
            etProfesion.setText(preferShared.getProfesion())
            etCorreoPersonal.setText(preferShared.getCorreo())
            etDescripPersonal.setText(preferShared.getDescripcion())
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