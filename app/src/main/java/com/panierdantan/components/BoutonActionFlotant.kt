import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panierdantan.R

@Composable
fun BoutonActionFlotant(text: String, onClickQrCode:()-> Unit) {
    Button(
        onClick = { onClickQrCode() },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth() // Prend la largeur maximale disponible
            .padding(16.dp), // Ajoute un padding pour l'apparence
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF85FDFF), // Couleur du bouton en hexadécimal (bleu)
            contentColor = Color.White // Couleur du contenu (texte et icône) en blanc
        )
    ) {
        Icon(
            imageVector = Icons.Default.Star, // Icône utilisée (Ici, l'icône "Favorite" de Material Icons)
            contentDescription = null, // Description de l'icône pour l'accessibilité
            tint = Color.Black // Couleur de l'icône en blanc
        )
        Text(
            text = text,
            modifier = Modifier
                .padding(start = 8.dp) // Ajoute un padding entre l'icône et le texte
                .align(Alignment.CenterVertically), // Aligne le texte verticalement au centre
            style = TextStyle(fontSize = 16.sp, color = Color.Black) // Taille du texte en blanc
        )
    }
}
