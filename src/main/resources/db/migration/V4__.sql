ALTER TABLE company
DROP
CONSTRAINT fk_company_on_employment_details;

ALTER TABLE company
DROP
COLUMN employment_details_id;