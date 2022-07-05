/*
    Insert static_shipments_status records
*/
INSERT INTO `static_shipments_status` (`id`, `name`)
VALUES (1,'Shipment Acquired'), (2,'Temporary Stored'),
    (3,'Temporary Stored + Documents'),(4,'Completed');
/*
    Insert static_shipments_conditions records
*/
INSERT INTO `static_shipments_condition` (`id`, `name`)
VALUES (1,'Good Conditions'), (2,'Not Good Conditions');
/*
    Insert shipments records
*/
INSERT INTO `shipments` (`id`, `_from`, `tracking_number`, `received_at`, `status_id`, `condition_id`, `note`)
VALUES
	(1,'ospedale tal de tali','123456789','2019-08-08 07:00:00',2,1,'bla bla'),
	(2,'Garibaldi','34567123456','1996-12-31 16:45:00',1,1,NULL),
	(3,'Garibaldi','ab-34rgt67','2003-09-26 19:59:00',1,1,'sssss-1-35:0978/90');
/*
    Insert static_shipments_boxes_status records
*/
INSERT INTO `static_shipments_boxes_status` (`id`, `name`)
VALUES (1,'Stored. Ready to be processed'),(2,'Completed');
/*
    Insert shipments_boxes records
*/
INSERT INTO `shipment_boxes` (`id`, `shipment_id`, `box_id`, `name`, `location_id`, `location_path`, `status_id`)
VALUES
	(1,1,'B49A89329BB',NULL,9,'Freezer 1/Division 1/Drawer 1/Slot 3',1),
	(2,2,'B7135B8BD1B',NULL,7,'Freezer 1/Division 1/Drawer 1/Slot 1',1),
	(3,3,'B065E4EDBC8',NULL,7,'Freezer 1/Division 1/Drawer 1/Slot 1',1);