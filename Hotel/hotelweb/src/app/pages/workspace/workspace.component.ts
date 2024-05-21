import { Component, OnInit } from '@angular/core';
import { BaseService } from 'src/app/services/base.service';

@Component({
  selector: 'app-workspace',
  templateUrl: './workspace.component.html',
  styleUrls: ['./workspace.component.css']
})
export class WorkspaceComponent {
rooms:any
selectedRoom:any
renters:any
rentings:any
constructor(private base:BaseService){
  this.getRooms()
  this.getRenters()
  this.getRentings()
}

roomcol =[
  {key:"id", text:"ID", type:"plain"},
  { key: "szoba_szam", text: "Szám", type: "text" },
  { key: "szoba_merete", text: "Méret", type: "text" },
  { key: "agyak_szama", text: "Ágyak", type: "text" }, 
  { key: "terasz", text: "Terasz", type: "text" }, 
  { key: "haziallat", text: "Háziállat", type: "text" }
]
rentercol =[
  {key:"id", text:"ID", type:"plain"},
  {key:"nev", text:"Név", type:"text"},
  {key:"szuletesi_datum", text:"Születési Dátum", type:"text"}
]
rentingcol=[
  {key:"id", text:"ID", type:"plain"},
  {key:"renter.nev", text:"Foglaló neve", type:"text"},
  {key:"szoba.szam", text:"Szoba száma", type:"text"},
  {key:"foglalas_eleje", text:"Foglalás kezdete", type:"text"},
  {key:"foglalas_vege", text:"Foglalás vége", type:"text"}
]

getRooms(){
  this.base.getRooms(this.rooms).subscribe(
    (res:any)=>{
      this.rooms = res.data
      console.log(this.rooms)
    }
  )
}
getRenters(){
  this.base.getRenters(this.renters).subscribe(
    (res:any)=>{
      this.renters = res.data
      console.log(this.renters)
    }
  )
}
getRentings(){
  this.base.getRentings(this.rentings).subscribe(
    (res:any)=>{
      this.rentings = res.data
      console.log(this.rentings)
    }
  )
}

updateRoom(id: any, data: any) {
  this.base.updateRoom(id, data).subscribe(
    (res: any) => {
      console.log('Szoba frissítve:', res);
      this.getRooms();
    },
    (error: any) => {
      console.error('Szoba frissítése sikertelen:', error);
    }
  );
}

deleteRoom(id: any) {
  this.base.deleteRoom(id).subscribe(
    (res: any) => {
      console.log('Szoba törölve:', res);
      this.getRooms();
    },
    (error: any) => {
      console.error('Szoba törlése sikertelen:', error);
    }
  );
}

getNestedValue(data: any, key: string): any {
  const keys = key.split('.'); // Kulcs felbontása pontok mentén
  let value = data;
  for (const k of keys) {
    if (value && value.hasOwnProperty(k)) {
      value = value[k]; // Frissítjük az értéket az új objektummal
    } else {
      return undefined; // Ha valami hiányzik, visszaadunk undefined-et
    }
  }
  return value; // Visszaadjuk az értéket
}
showCoursesDetails(room: any) {
  this.selectedRoom = room
  console.log(this.selectedRoom);
}

}