//Written by LDG

package kotlinfunction

import java.lang.IllegalArgumentException

//next node shows code overlap
class User(val id : Int, val name:String, val address:String)
fun saveUser(user:User){
    if(user.name.isEmpty()){                //here
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty name"
        )
    }

    if(user.address.isEmpty()){             //here
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty address"
        )
    }
}

//Improve it
fun saveUserImproved(user:User){
    fun validate(user:User,
                value:String,
                fieldName:String){
        if(value.isEmpty()){
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user,user.name,"Name")
    validate(user,user.address,"Address")
}

//remove User parameter

fun saveUserImprove2(user:User){
    fun validate(value:String,
                 fieldName:String){
        if(value.isEmpty()){
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName"   //can access outer parameter
            )
        }
    }
    validate(user.name,"Name")
    validate(user.address,"Address")
}

//or make it by User class's extension method
fun User.validateBeforeSave(){
    fun validate(value:String,
                 fieldName:String){
        if(value.isEmpty()){
            throw IllegalArgumentException(
                "Can't save user ${id}: empty $fieldName"   //can access outer parameter
            )
        }
    }
    validate(name,"Name")
    validate(address,"Address")
}
fun saveUserFinal(user:User){
    user.validateBeforeSave()
}