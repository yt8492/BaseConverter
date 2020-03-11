import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import kotlin.browser.document
import kotlin.math.pow

fun main() {
    val decInput = document.getElementById("decInput") as HTMLInputElement
    val hexOutput = document.getElementById("hexOutput") as HTMLInputElement
    val convertToHexButton = document.getElementById("convertToHexButton") as HTMLButtonElement
    convertToHexButton.addEventListener("click", {
        val input = decInput.value
        val dec = try {
            input.toDouble()
        } catch (e: NumberFormatException) {
            return@addEventListener
        }
        val hex = dec.toString(16)
        hexOutput.value = hex
    })

    val hexInput = document.getElementById("hexInput") as HTMLInputElement
    val decOutput = document.getElementById("decOutput") as HTMLInputElement
    val convertToDecButton = document.getElementById("convertToDecButton") as HTMLButtonElement
    convertToDecButton.addEventListener("click", {
        val input = hexInput.value
        val dec = parseInt(input, 16)
        decOutput.value = dec.toString()
    })
}

fun Number.toString(base: Int): String {
    val i = this
    return js("i.toString(base)").toString().toUpperCase()
}

fun parseInt(hex: String, base: Int): Int {
    return js("parseInt(hex, base)") as Int
}
