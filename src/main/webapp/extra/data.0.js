function loadAPIEtudiant() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET","api/user", true);
    xhr.onload = function () {
        if (this.status == 200){
            var cunt = this.responseText.split("'");
            var c = "<font font=\"arial\" size=\"12\" ><table border='1px'><tr><th>"+cunt[0]+"</th>";
            for (let i = 1; i < cunt.length-1; i++) {
                c += "<th>"+cunt[i]+"</th>";
            }
            c += "<th>"+cunt[cunt.length-1]+"</th></tr></table></font>";
            document.getElementById("etudiant").innerHTML = c;
            //document.write(this.responseText.split(','));
        }

    }
    xhr.send();
}
function loadAPINote() {
    var xhr = new XMLHttpRequest();

    xhr.open("GET","api/note", true);

    xhr.onload = function () {
        if (this.status == 200){
          //  var eleve = new Eleve(this.responseText.toString());
        //    var res = eleve.toTable();
            console.log(this.responseText);
            let res = this.responseText;

            document.getElementById("note").innerHTML = res;
            }


         }

    xhr.send();
}
//pas encore implémenté
class Note{
    constructor(note,denum, session) {
        this.note1 = note.substr(1,3)+"/"+denum.substr(1,3);
        this.note2 = note.substr(5,7)+"/"+denum.substr(5,7);
        this.note3 = note.substr(10)+"/"+denum.substr(10);
    }
    get note1(){
        return this.note1;
    }
    get note2(){
        return this.note2;
    }
    get note3(){
        return this.note3;
    }
    somme(){
        var a = 0,b = 0,c = 0;
        if (this.note1.split("/")[0] !== "" || this.note1.split("/")[0] !== "-")
           a = parseInt(this.note1.split("/")[0]);
        if (this.note2.split("/")[0] !== "" || this.note2.split("/")[0] !== "-")
           b = parseInt(this.note2.split("/")[0]);
        if (this.note3.split("/")[0] !== "" || this.note3.split("/")[0] !== "-")
           c = parseInt(this.note2.split("/")[0]);
    return (a+b+c);
    }
    toTable(){
        return "<td>"+this.somme()+"</td><td>"+this.note1()+"</td><td>"+this.note2()+"</td><td>"+this.note3()+"</td>";
    }

}
class Cours{
    constructor(nom,titre) {
        this.nom = nom;
        this.titre = titre;
        this.listeNotes = new List();
    }
    addNote(liste){
        this.listeNotes.addAll(liste);
    }
    addNote(note){
        this.listeNotes.add(note);
    }
    get listeNotes(){
        return this.listeNotes;
    }
    get nom(){
        return this.nom;
    }
    get titre(){
        return this.nom;
    }
    toTable(){
        var str = "<tr><td>"+this.nom()+"</td><td>"+this.titre()+"</td>";
            for (let i = 0; i<this.listeNotes().length;i++){
                if (i == 0)
                str += this.listeNotes().get(i).toTable()+"</tr>";

                str += "<tr><td></td>"+ this.listeNotes().get(i).toTable()+"</tr>";
            }
            str += "<br><br>";
            return str;
    }
}
class Eleve{

    constructor(str) {
        this.listeCours = new mapper().mapEleve(str);
    }
    addcours(listeCours){
        this.listeCours.addAll(listeCours);
    }
    addcours(cour){
        this.listeCours.add(cours);
    }
    get listeCours(){
        return this.listeCours;
    }
    toTable(){
        var str;
        for (let i = 0; i<this.listeCours().length;i++){
            str += "<div>"+this.listeCours().toTable()+"</div>";
        }
        return str;
    }

}
class mapper{
    constructor() {
    }
    mapEleve(strToMap){
        var splitToCours = strToMap.split("\n");
        var eleve = new Eleve();
        for (let i = 0; i < splitToCours.length; i++){
            eleve.addcours(this.mapClasse(splitToCours[i]))
        }
        return eleve.listeCours();
    }
    mapClasse(str){
        var s = str.split("/");
        var classe = new Cours(s[1].split("'")[1],s[1].split("'")[2]);
        for (let i = 0; i < s.length;i++){
            classe.addNote(this.mapNote(s[i]));
        }
        return classe;
    }
    mapNote(str){
        var k = str.indexOf("[",10);
        var s = str.substr(k);
        s =  s.split("'");
        var note = new Note(s[0],s[1],"");
        return note;
    }
}
//pas encore implémenté