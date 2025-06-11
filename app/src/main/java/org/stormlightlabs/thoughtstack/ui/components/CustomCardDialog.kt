package org.stormlightlabs.thoughtstack.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

/**
 * Dialog for adding a custom card with title, description, and optional photo.
 */
@Composable
fun CustomCardDialog(
    onDismiss: () -> Unit,
    onSave: (title: String, duration: Int, description: String, photoUri: String?) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var duration by remember { mutableIntStateOf(0) }
    var description by remember { mutableStateOf("") }
    var photoUri by remember { mutableStateOf<Uri?>(null) }

    // Launcher to pick an image from gallery
    val launcher = rememberLauncherForActivityResult(GetContent()) { uri: Uri? ->
        photoUri = uri
    }

    AlertDialog(onDismissRequest = onDismiss, title = { Text("Add Custom Card") }, text = {
        Column {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Button(onClick = { launcher.launch("image/*") }) {
                Text("Pick Photo (optional)")
            }
            photoUri?.let { uri ->
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )
            }
        }
    }, confirmButton = {
        TextButton(
            onClick = { onSave(title.trim(), duration, description.trim(), photoUri?.toString()) },
            enabled = title.isNotBlank() && description.isNotBlank()
        ) {
            Text("Save")
        }
    }, dismissButton = {
        TextButton(onClick = onDismiss) { Text("Cancel") }
    })
}
