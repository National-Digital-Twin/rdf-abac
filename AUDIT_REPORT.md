# Open-Source Compliance & Code Audit Report

**Repository:** `rdf-abac`  
**Date of Last Audit:** `2025-03-21`  
**Reviewed By:** `Kainos Software`
<!-- SPDX-License-Identifier: OGL-UK-3.0 -->

---

## Overview

As part of NDTP’s commitment to open-source compliance and security best practices, this repository has undergone
a comprehensive audit using FOSSology and Copyleaks to verify:

- All third-party components are properly licensed and attributed.
- No proprietary or restricted-license code has been included.
- No unintentional code duplication from external sources.
- All code follows NDTP’s dual-license model (Apache 2.0 for code, OGL-UK-3.0 for documentation).

---

## Tools Used for the Audit

| Tool          | Purpose                                           | Scan Date    |
|---------------|---------------------------------------------------|--------------|
| FOSSology     | Open-source license compliance scanner            | `2025-03-21` |
| Copyleaks     | AI-driven plagiarism and duplicate code detection | `2025-03-21` |
| Manual Review | Compliance team manually reviewed flagged files   | `2025-03-21` |

---

## License Compliance Check (FOSSology)

Issues Identified:

- FSSology scans identified potential GPL2.0-only and GPL license matches but a manual review confirmed these to be false positives
- Action Taken: None required

All required attributions have been added to [NOTICE.md](./NOTICE.md).

---

## Duplicate Code and Attribution Check (Copyleaks)

| Scanned Files            | Plagiarism Risk Detected? | Source Match | Resolution |
|--------------------------|---------------------------|--------------|------------|
| TokenizerABAC.java       | `Yes` | [Source](https://raw.githubusercontent.com/apache/jena/master/jena-arq/src/main/java/org/apache/jena/riot/tokens/TokenizerText.java) | Numerous matches to file in GitHub. Comment in file says, “Derived from TokenizerText in Jena” Original file released under Apache License 2.0   |
| AbstractTestLabelsStore.java | `Yes`| [Source](https://www.cia.gov/the-world-factbook/about/archives/2023/field/background) | Test string in code is 7 paragraphs of text from CIA World Fact Book |

Issues Identified and Resolutions:

- None required

All unintentional code reuse has been resolved or attributed correctly.

---

## Final Compliance Status

After running FOSSology and Copyleaks scans, this repository is:

- Fully compliant
- Necessary actions taken

Next Steps:

- None required

Maintained by the National Digital Twin Programme.
