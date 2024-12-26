import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var word: ArrayList<String> = ArrayList<String>()
    var sentence: ArrayList<String> = ArrayList<String>()

    for (i in 0 until 20) {
        word.add(sc.nextLine())
        if (word[i][0].code == 35 && word[i][1].code == 35) break;
    }

    for (i in 0..100) {
        sentence.add(sc.nextLine())
        if (sentence[i][0].code == 35) break;
    }
    for (i in 0 until sentence.size - 1) { //문장의 배열
        for (j in 0 until sentence[i].length - 3) {//한문장의 길이
            for (k in 0 until word.size - 1) {//단어의 배열
                if (sentence[i][j] == word[k][0]) { //시작 지점 발견시
                    //끝지점까지 있는지 찾아야함 j로 찾아야함
                    var temp: Int = j + 1
                    while (temp < sentence[i].length - 3) {
                        if ((sentence[i][temp].code !in 65..90) && (sentence[i][temp].code !in 97..122)) {
                            break
                        }
                        if (sentence[i][temp] == word[k][1]) {
                            for (p in j + 1 until temp) {
                                var toCharArray = sentence[i].toCharArray()
                                toCharArray[p] = '*'
                                sentence[i] = String(toCharArray)
                            }
                        }
                        temp++
                    }
                }
            }
        }
    }
    for(i in 0 until sentence.size - 1) {
        println(sentence[i])
    }
}