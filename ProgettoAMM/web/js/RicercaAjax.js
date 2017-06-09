/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//crea un elemento div 
function createElement(utenti){
    var img = $("<img>")
            .attr("alt","Foto Profilo")
            .attr("src",utenti.imgProfilo);
    var name = $("<h2>").html(utenti.nome);
    var link = $("<a>")
            .attr("href", "index.html?user=" + utenti.id)
            .html("Link al Profilo");
    
    var userData = $("<div>")
            .attr("class","userData")
            .append(name)
            .append(link);
    var profilePic = $("<div>")
            .attr("class","profilePic")
            .append(img);
    
    
    return $("<div>")
            .attr("class","user")
            .append(profilePic)
            .append(userData);
}

function stateSuccess(data){
    var userListPage = $("#usersList");
    
    $(userListPage).empty();
    for(var item in data){
        $(userListPage).append(createElement(data[item]));
    }
}
function stateFailure(data, state){
    console.log(state + data);
}

$(document).ready(function(){
    $("#idbottone").click(function(){
        var nomeRicerca = $("#search")[0].value;
        console.log("forse");
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                nomeUtenteCercato: nomeRicerca
            },
            dataType:"json",
            success: function(data, state){
                console.log(data);
                stateSuccess(data)
            },
            error: function(data, state){
                console.log("no");
                stateFailure(data, state)
            }
        });
    })
});
