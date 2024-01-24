enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario(val nome: String)

data class Conteudo(
    var nome: String,
    val duracao: Int = 40,
    val nivel: Nivel = Nivel.BASICO
)

data class Formacao(val nome: String, val conteudos: List<Conteudo>) {

    val inscritos = mutableSetOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (inscritos.add(usuario)) {
            println("Matrícula realizada, para ${usuario.nome} na formação $nome.")
        } else {
            println("${usuario.nome} já está matriculado na formação $nome.")
        }
    }

    fun printarMaterias() {
        println("\nMatérias da formação $nome:")
        conteudos.forEach { println("${it.nome} - Nível: ${it.nivel}") }
    }
}

fun main() {
    val designdemoda = listOf(
        Conteudo("Desenho de Moda", 70, Nivel.BASICO),
        Conteudo("Processo Criativo", 50, Nivel.INTERMEDIARIO),
        Conteudo("Linguagem Visual", 60, Nivel.AVANÇADO)
 
    )
    val EngenhariaMecatronica = listOf(
        Conteudo("Cálculo Diferencial e Integral I", 85, Nivel.BASICO),
        Conteudo("Geometria Analítica e Álgebra Linear", 40, Nivel.INTERMEDIARIO),
        Conteudo("Sistemas Hidráulicos E Pneumáticos", 50, Nivel.AVANÇADO)
    )

    val Astronomia = listOf(
        Conteudo("Programa Espacial Brasileiro", 80, Nivel.BASICO),
        Conteudo("Diagrama H-R e Evolução Estelar", 70, Nivel.INTERMEDIARIO),
        Conteudo("Estrelas Binárias e Variáveis", 90, Nivel.AVANÇADO)
    )

    val formacoes = listOf(
        Formacao("Design de Moda", designdemoda),
        Formacao("Engenharia Mecatrônica", EngenhariaMecatronica),
        Formacao("Astronomia", Astronomia)
    )

    val usuarios = listOf(
        Usuario("Rayanne"),
        Usuario("Osmar"),
        Usuario("Arthur")
    )


    formacoes.zip(usuarios).forEach { (formacao, usuario) ->
        formacao.matricular(usuario)
    }

    formacoes.forEach { it.printarMaterias() }
}
