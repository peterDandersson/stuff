/**
 * Created by Elev1 on 2017-03-21.
 */
var isClicked = false;
var btnClicked = function () {
    if(isClicked){
        document.getElementById("drop-down-content").className = "drop-click";
    } else {
        document.getElementById("drop-down-content").className = "";
    }
}