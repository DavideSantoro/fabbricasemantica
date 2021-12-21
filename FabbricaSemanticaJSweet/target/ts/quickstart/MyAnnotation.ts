/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di annotazione "myAnnotation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    export class MyAnnotation extends quickstart.AnnotationValidation {
        /**
         * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
         */
        public static SERVLET_URL : string = "myAnnotation.jsp";

        /**
         * Stringa che identifica il nome del task
         */
        public static TASK_NAME : string = "task=MY_ANNOTATION";

        public static main(args : string[]) {
            let form1 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(MyAnnotation.SERVLET_URL, "5% 23%");
            let form2 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10.5% 75%");
            let richiesta : HTMLLabelElement = quickstart.GestioneElementi.costruisciEtichetta("Comporre la parola associata alla definizione trascinando le lettere nei riquadri bianchi all\'interno dei riquadri blu");
            $(richiesta).css("font-weight", "bold").css("white-space", "nowrap");
            let description : HTMLLabelElement = document.createElement("label");
            $(description).css("font-style", "italic");
            let divPrimaLettera : HTMLDivElement = quickstart.GestioneElementi.costruisciDrag();
            let divSecondaLettera : HTMLDivElement = quickstart.GestioneElementi.costruisciDrag();
            let divTerzaLettera : HTMLDivElement = quickstart.GestioneElementi.costruisciDrag();
            let divQuartaLettera : HTMLDivElement = quickstart.GestioneElementi.costruisciDrag();
            let divQuintaLettera : HTMLDivElement = quickstart.GestioneElementi.costruisciDrag();
            let arrayInteri : number[] = [0, 1, 2, 3, 4];
            for(let i : number = 4; i > 0; i--) {{
                let randomInt : number = (<number>Math.floor(Math.random() * i)|0);
                let lastInt : number = arrayInteri[i];
                arrayInteri[i] = arrayInteri[randomInt];
                arrayInteri[randomInt] = lastInt;
            };}
            $.getJSON(quickstart.AnnotationValidation.REST_URL, MyAnnotation.TASK_NAME, ((divTerzaLettera,divQuintaLettera,description,arrayInteri,divQuartaLettera,divPrimaLettera,divSecondaLettera) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sDescription : string = <any>(json["description"]);
                    $(description).text(sDescription);
                    $(divPrimaLettera).text(sWord.charAt(arrayInteri[0]) + "");
                    $(divSecondaLettera).text(sWord.charAt(arrayInteri[1]) + "");
                    $(divTerzaLettera).text(sWord.charAt(arrayInteri[2]) + "");
                    $(divQuartaLettera).text(sWord.charAt(arrayInteri[3]) + "");
                    $(divQuintaLettera).text(sWord.charAt(arrayInteri[4]) + "");
                    return null;
                }
            })(divTerzaLettera,divQuintaLettera,description,arrayInteri,divQuartaLettera,divPrimaLettera,divSecondaLettera));
            let divSpazio : HTMLDivElement = document.createElement("div");
            $(divSpazio).css("height", "5px");
            $(divSpazio).css("width", "90px");
            $(divSpazio).css("margin", "5% 10%");
            let hiddenInput1 : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hidden1");
            let hiddenInput2 : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hidden2");
            let hiddenInput3 : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hidden3");
            let hiddenInput4 : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hidden4");
            let hiddenInput5 : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hidden5");
            let divDestinazione1 : HTMLDivElement = quickstart.GestioneElementi.costruisciDrop(hiddenInput1);
            let divDestinazione2 : HTMLDivElement = quickstart.GestioneElementi.costruisciDrop(hiddenInput2);
            let divDestinazione3 : HTMLDivElement = quickstart.GestioneElementi.costruisciDrop(hiddenInput3);
            let divDestinazione4 : HTMLDivElement = quickstart.GestioneElementi.costruisciDrop(hiddenInput4);
            let divDestinazione5 : HTMLDivElement = quickstart.GestioneElementi.costruisciDrop(hiddenInput5);
            let divInputHidden : HTMLDivElement = document.createElement("div");
            $(divInputHidden).append(hiddenInput1, hiddenInput2, hiddenInput3, hiddenInput4, hiddenInput5);
            $(form1).append(divInputHidden, quickstart.GestioneElementi.divEtichetta(richiesta), $(quickstart.GestioneElementi.divEtichetta(description)).css("margin", "3% 0%"), divDestinazione1, divDestinazione2, divDestinazione3, divDestinazione4, divDestinazione5, divSpazio, divPrimaLettera, divSecondaLettera, divTerzaLettera, divQuartaLettera, divQuintaLettera, $(quickstart.GestionePulsanti.costruisciNext()).css("margin-top", "23px"), quickstart.GestionePulsanti.costruisciRestart([divPrimaLettera, divSecondaLettera, divTerzaLettera, divQuartaLettera, divQuintaLettera], [divDestinazione1, divDestinazione2, divDestinazione3, divDestinazione4, divDestinazione5]), $(quickstart.GestioneLink.costruisciHome()).css("margin-top", "15px"));
            $(form2).append($(quickstart.GestionePulsanti.costruisciSkip()).css("margin-top", "22px"), quickstart.GestioneLink.costruisciLogout("4% 100%"));
            Fabbrica.costruisciPagina(form1, form2);
        }
    }
    MyAnnotation["__class"] = "quickstart.MyAnnotation";

}


quickstart.MyAnnotation.main(null);
