import {OwnerModel} from "./owner.model";

export interface Item {
  title: string;
  accepted_answer_id: any;
  answer_count: number;
  closed_date: Date;
  closed_reason: string;
  content_license: string;
  creation_date: Date;
  is_answered: boolean;
  last_activity_date: Date;
  last_edit_date: Date;
  link: string;
  owner: OwnerModel
  question_id: number;
  score: number;
  tags: string[];
  view_count: number;
}
