select z.*, e.name as e_name, a.name as a_name, s.name as s_name from zoneInfo as z
			join entireRegionalCode as e
			on z.zone_entireRegionalCode = e.code
			join areaRegionalCode as a
			on z.zone_areaRegionalCode = a.code
			join stateRegionalCode as s
			on z.zone_stateRegionalCode = s.code
 		where
 			zone_entireRegionalCode = 'A1'
	 		and zone_areaRegionalCode = 'B01'
	 		and zone_officalName like '%a%'
 		order by zone_registerNo desc;