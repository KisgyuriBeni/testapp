SELECT rentings.foglalas_eleje, rentings.foglalas_vege, 
renters.nev, rooms.szoba_szam, rooms.agyak_szama
from rentings
Join rooms on rentings.szoba_id = rooms.id
Join renters on rentings.foglalo_id = renters.id
where rentings.foglalo_id = ?;