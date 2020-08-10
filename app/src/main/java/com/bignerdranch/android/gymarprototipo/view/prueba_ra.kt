package com.bignerdranch.android.gymarprototipo.view

import android.app.AlertDialog
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.gymarprototipo.R
import com.google.ar.core.Anchor
import com.google.ar.core.Plane
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import kotlinx.android.synthetic.main.activity_prueba_ra.*

class prueba_ra : AppCompatActivity() {
    private lateinit var arFragment: ArFragment
    private lateinit var selectedObject: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba_ra)

        arFragment = supportFragmentManager.findFragmentById(R.id.sceneform_fragment) as ArFragment

        exercise_prueba.setOnClickListener { selectedObject = Uri.parse("file:///android_asset/rp_sophia_animated_003_idling.sfb")}

        arFragment.setOnTapArPlaneListener{ hitResult, plane, motionEvent ->
            if (plane.type == Plane.Type.HORIZONTAL_UPWARD_FACING){
                val anchor = hitResult.createAnchor()

                if (this::selectedObject.isInitialized){
                    placeObject(arFragment,anchor,selectedObject)
                }
            }
        }
    }

    private fun placeObject(arFragment: ArFragment, anchor: Anchor, uri: Uri){
        ModelRenderable.builder()
            .setSource(arFragment.context, uri)
            .build()
            .thenAccept {renderable ->
                addNodeToScene(arFragment,anchor,renderable)
            }
            .exceptionally {throwable ->
                showErrorMessage()
            }
    }

    /**
     * @param renderable
     */
    private fun addNodeToScene(arFragment: ArFragment, anchor: Anchor, renderable: Renderable){
        val anchorNode = AnchorNode(anchor)
        val transformableNode = TransformableNode(arFragment.transformationSystem)
        transformableNode.renderable = renderable
        transformableNode.setParent(anchorNode)
        arFragment.arSceneView.scene.addChild(anchorNode)
        transformableNode.select()
    }

    private fun showErrorMessage(): Void{
        AlertDialog.Builder(this)
            .setTitle("Erro")
            .setMessage("Erro ao carregar modelo")
            .setNeutralButton("Ok", null)
            .create()
            .show()

        val voidConstructor = Void::class.java.getDeclaredConstructor()
        voidConstructor.isAccessible = true
        val void = voidConstructor.newInstance()
        return void
    }
}