open class Player(private  var nama: String,private  var hp: Int,private  var atk: Int) {
    open fun status() {
        println("Class: $nama")
        println("HP: $hp")
        println("ATK: $atk")
    }

    open fun attack(target: Player) {
        println("$nama menyerang ${target.nama}!")
        val damage = atk
        target.getHit(damage)
        println("=================")
    }

    open fun getHit(damage: Int) {
        if (hp > 0) {
            hp -= damage
            println("$nama menerima damage sebesar $damage")
            if (hp <= 0) {
                hp = 0
                println("$nama DIE!")
            }
        } else {
            println("$nama Has been die!")
        }
    }
}

class Hitter(nama: String, hp: Int, atk: Int) : Player(nama, hp, atk) {
    // tidak perlu override metode karena implementasinya sama dengan superclass
}

class Magician(nama: String, hp: Int, atk: Int) : Player(nama, hp, atk) {
    // tidak perlu override metode karena implementasinya sama dengan superclass
}

class Tanker(nama: String, hp: Int, atk: Int) : Player(nama, hp, atk) {
    // tidak perlu override metode karena implementasinya sama dengan superclass
}

fun main(args: Array<String>) {
    val hitter = Hitter("Hitter", 100, 50)
    val magician = Magician("Magician", 80, 70)
    val tanker = Tanker("Tanker", 200, 30)

    println("==== INIT ====")
    hitter.status()
    magician.status()
    tanker.status()

    println("==== SCENE ====")
    magician.attack(hitter)
    tanker.attack(hitter)
    magician.attack(hitter)

    println("==== STATUS ====")
    hitter.status()
    magician.status()
    tanker.status()
}
