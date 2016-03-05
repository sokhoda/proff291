/**
 * Created by elenabugercuk on 22.02.16.
 */

quest = '';

quest = XQuerry('for $_i in collaborators return $_i ');
size = quest.length;
i=0;
while (i<size){
    console.log("Data " + i);
    openDoc(URLFromDocID(i));


    i++;
}
quest = XQuery('for $_i in collaborators return $_i ');


