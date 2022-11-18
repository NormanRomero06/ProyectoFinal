package ni.edu.uca.infopegue
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentCrudEmpresaBinding

class CrudEmpresa : Fragment() {
    private lateinit var binding: FragmentCrudEmpresaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrudEmpresaBinding.inflate(layoutInflater)
        Guardar()
        Acciones()
        AccionClean()
        BorrarDatos()
        CargarDatos()
        return binding.root
    }

    private fun Guardar() {

        binding.btnGuardar.setOnClickListener {


            if (binding.etNombre.text.toString().isNotEmpty()) {
                ShareObjectAdp.preferShared.saveNombre(binding.etNombre.text.toString())
            } else {
                Toast.makeText(this.context, "Inserte Un nombre de Empresa", Toast.LENGTH_SHORT).show()
            }

            if (binding.etDireccion.text.toString().isNotEmpty()) {
                ShareObjectAdp.preferShared.saveDireccion(binding.etDireccion.text.toString())
            }else {
                Toast.makeText(this.context,"Inserte una Direccion", Toast.LENGTH_SHORT).show()
            }

            if (binding.etJefeEmpresa.text.toString().isNotEmpty()) {
                ShareObjectAdp.preferShared.saveRepresentante(binding.etJefeEmpresa.text.toString())
            } else {
                Toast.makeText(this.context, "Inserte Un representante", Toast.LENGTH_SHORT).show()
            }
            if (binding.etContacto.text.toString().isNotEmpty()) {
                ShareObjectAdp.preferShared.saveContacto(binding.etContacto.text.toString())
            } else {
                Toast.makeText(this.context, "Digite un numero", Toast.LENGTH_SHORT).show()
            }

            if (binding.etCorreoEmpresa.text.toString().isNotEmpty()) {
                ShareObjectAdp.preferShared.saveCorreoEm(binding.etCorreoEmpresa.text.toString())
            } else {
                Toast.makeText(this.context, "Digite un correo", Toast.LENGTH_SHORT).show()
            }

            if (binding.etDescripEmpresa.text.toString().isNotEmpty()) {
                ShareObjectAdp.preferShared.saveDescripcionEm(binding.etDescripEmpresa.text.toString())
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
            etNombre.setText("")
            etDireccion.setText("")
            etJefeEmpresa.setText("")
            etContacto.setText("")
            etCorreoEmpresa.setText("")
            etDescripEmpresa.setText("")




        }
        Toast.makeText(this.context, "Campos limpios", Toast.LENGTH_SHORT).show()
    }

    private fun BorrarDatos() {
        binding.btnEliminar.setOnClickListener {
            with(binding) {
                ShareObjectAdp.preferShared.RemoveNombreEm(etNombre.text.toString())
                ShareObjectAdp.preferShared.RemoveDireccion(etDireccion.text.toString())
                ShareObjectAdp.preferShared.RemoveRepresentante(etJefeEmpresa.text.toString())
                ShareObjectAdp.preferShared.RemoveContactoEm(etContacto.text.toString())
                ShareObjectAdp.preferShared.RemoveCorreoEm(etCorreoEmpresa.text.toString())
                ShareObjectAdp.preferShared.RemoveDescripcionEM(etDescripEmpresa.text.toString())


            }
            Toast.makeText(this.context, "Datos Borrados", Toast.LENGTH_SHORT).show()
            limpiar()

        }
    }

    private fun CargarDatos() {
        with(binding) {
            etNombre.setText(ShareObjectAdp.preferShared.getNombre())
            etDireccion.setText(ShareObjectAdp.preferShared.getDireccion())
            etJefeEmpresa.setText(ShareObjectAdp.preferShared.getRepresentante())
            etContacto.setText(ShareObjectAdp.preferShared.getContacto())
            etCorreoEmpresa.setText(ShareObjectAdp.preferShared.getCorreo())
            etDescripEmpresa.setText(ShareObjectAdp.preferShared.getDescripcionEmp())
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



