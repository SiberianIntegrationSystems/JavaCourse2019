export const FILTER_TYPE_SINGLE_SELECT = 'single-select';

export const FILTER_CODE_QUESTION_ANSWERS_COUNT = 'question-answer-count';

export interface JournalFilterItem{
  type: string;
  code: string;
  value: string;
}
