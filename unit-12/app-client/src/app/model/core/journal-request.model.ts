import { JournalFilterItem } from 'src/app/model/core/journal-filter-item';

export interface JournalRequest {
  journalId: string;
  filters: JournalFilterItem[];
  search: string;
  page: number;
  pageSize: number;
}
