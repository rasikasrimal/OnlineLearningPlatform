DELIMITER //

CREATE TRIGGER before_insert_instructor
BEFORE INSERT ON instructors
FOR EACH ROW
BEGIN
    DECLARE next_id INT;
    SET next_id = COALESCE((SELECT MAX(instructor_id) FROM instructors), 0) + 100;
    SET NEW.instructor_custom_id = CONCAT('INS-', next_id);
END; //

DELIMITER ;
