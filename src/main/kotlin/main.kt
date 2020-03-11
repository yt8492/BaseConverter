import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import kotlin.browser.document
import kotlin.math.pow

@ExperimentalStdlibApi
fun main() {
    val decInput = document.getElementById("decInput") as HTMLInputElement
    val hexOutput = document.getElementById("hexOutput") as HTMLInputElement
    val convertToHexButton = document.getElementById("convertToHexButton") as HTMLButtonElement
    convertToHexButton.addEventListener("click", {
        val input = decInput.value
        val dec = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            return@addEventListener
        }
        val hex = dec.toHexString()
        hexOutput.value = hex
    })

    val hexInput = document.getElementById("hexInput") as HTMLInputElement
    val decOutput = document.getElementById("decOutput") as HTMLInputElement
    val convertToDecButton = document.getElementById("convertToDecButton") as HTMLButtonElement
    convertToDecButton.addEventListener("click", {
        val input = hexInput.value
        val dec = input.toDecInt()
        decOutput.value = dec.toString()
    })
}

@ExperimentalStdlibApi
fun Int.toHexString(): String {
    return buildString {
        var acc = this@toHexString
        while (acc > 0) {
            val quo = acc / 16
            val rem = acc % 16
            insert(0, rem.toHexChar())
            acc = quo
        }
    }
}

fun Int.toHexChar(): Char {
    return when (this) {
        in 0..9 -> this.toString().first()
        10 -> 'A'
        11 -> 'B'
        12 -> 'C'
        13 -> 'D'
        14 -> 'E'
        15 -> 'F'
        else -> throw IllegalArgumentException()
    }
}

fun String.toDecInt(): Int {
    return this.foldIndexed(0) { index, acc, hexChar ->
        val digit = this.length - index
        val dec = hexChar.toDecInt() * 16.0.pow(digit.toDouble() - 1).toInt()
        acc + dec
    }
}

fun Char.toDecInt(): Int {
    return when (this) {
        in '0'..'9' -> this.toString().toInt()
        'a', 'A' -> 10
        'b', 'B' -> 11
        'c', 'C' -> 12
        'd', 'D' -> 13
        'e', 'E' -> 14
        'f', 'F' -> 15
        else -> throw IllegalArgumentException()
    }
}