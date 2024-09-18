DROP SEQUENCE collective_convention_seq CASCADE;

DROP SEQUENCE company_seq CASCADE;

DROP SEQUENCE department_seq CASCADE;

DROP SEQUENCE employee_employment_details_seq CASCADE;

DROP SEQUENCE employee_seq CASCADE;

DROP SEQUENCE employment_category_seq CASCADE;

DROP SEQUENCE employment_details_seq CASCADE;

DROP SEQUENCE employment_position_seq CASCADE;

DROP SEQUENCE employment_qualification_seq CASCADE;

ALTER TABLE collective_convention
    ALTER COLUMN employment_details_id DROP NOT NULL;

ALTER TABLE department
    ALTER COLUMN employment_details_id DROP NOT NULL;

ALTER TABLE employment_category
    ALTER COLUMN employment_details_id DROP NOT NULL;

ALTER TABLE employment_position
    ALTER COLUMN employment_details_id DROP NOT NULL;

ALTER TABLE employment_qualification
    ALTER COLUMN employment_details_id DROP NOT NULL;