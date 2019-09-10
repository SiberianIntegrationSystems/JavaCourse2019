import { JournalItem } from 'src/app/model/core/journal-item.model';

export interface JournalResult {
  total: number;
  items: JournalItem[];
}
