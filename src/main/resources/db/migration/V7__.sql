ALTER TABLE employee_employment_details
DROP
COLUMN collective_conventions_id;

ALTER TABLE employee_employment_details
DROP
COLUMN department_id;

ALTER TABLE employee_employment_details
DROP
COLUMN employment_category_id;

ALTER TABLE employee_employment_details
DROP
COLUMN employment_positions_id;

ALTER TABLE employee_employment_details
DROP
COLUMN employment_qualifications_id;

ALTER TABLE employee_employment_details
    ADD collective_conventions_id BIGINT NOT NULL;

ALTER TABLE employee_employment_details
    ALTER COLUMN collective_conventions_id SET NOT NULL;

ALTER TABLE employee_employment_details
    ADD department_id BIGINT NOT NULL;

ALTER TABLE employee_employment_details
    ALTER COLUMN department_id SET NOT NULL;

ALTER TABLE employee_employment_details
    ADD employment_category_id BIGINT NOT NULL;

ALTER TABLE employee_employment_details
    ALTER COLUMN employment_category_id SET NOT NULL;

ALTER TABLE employee_employment_details
    ADD employment_positions_id BIGINT NOT NULL;

ALTER TABLE employee_employment_details
    ALTER COLUMN employment_positions_id SET NOT NULL;

ALTER TABLE employee_employment_details
    ADD employment_qualifications_id BIGINT NOT NULL;

ALTER TABLE employee_employment_details
    ALTER COLUMN employment_qualifications_id SET NOT NULL;