import { JournalItem } from 'src/app/model/core/journal-item.model';

export interface QuestionJournalItem extends JournalItem {
  answersCount: number;
}
