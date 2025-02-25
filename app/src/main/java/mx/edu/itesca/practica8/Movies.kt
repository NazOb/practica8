package mx.edu.itesca.practica8

data class Movies(
    var title:String,
    var image:Int,
    var header:Int,
    var sinopsis:String,
    var seats:ArrayList<Client>)
