SELECT rentings.id, rentings.szoba_id, rentings.foglalo_id, rentings.foglalas_eleje, rentings.foglalas_vege
FROM rentings
JOIN rooms ON rentings.szoba_id = rooms.id
JOIN renters ON rentings.foglalo_id = renters.id;